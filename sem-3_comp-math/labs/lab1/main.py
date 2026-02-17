import sys


def safe_float_input(value):
    try:
        return float(value)
    except ValueError:
        raise ValueError("Ошибка: введено не число.")


def input_from_keyboard():
    try:
        n = int(input("Введите размерность матрицы (n <= 20): "))
        if n <= 0 or n > 20:
            raise ValueError("Размерность должна быть 1 <= n <= 20")

        print("Введите матрицу A построчно:")
        A = []
        for i in range(n):
            row = input().split()
            if len(row) != n:
                raise ValueError("Неверное количество элементов в строке.")
            A.append([safe_float_input(x) for x in row])

        print("Введите вектор b:")
        b_input = input().split()
        if len(b_input) != n:
            raise ValueError("Неверное количество элементов в векторе b.")
        b = [safe_float_input(x) for x in b_input]

        eps = safe_float_input(input("Введите точность: "))
        if eps <= 0:
            raise ValueError("Точность должна быть положительной.")

        return A, b, eps
    except Exception as e:
        print("Ошибка ввода:", e)
        sys.exit(1)


def input_from_file(filename):
    try:
        with open(filename, 'r') as f:
            lines = f.readlines()

        n = int(lines[0])
        if n <= 0 or n > 20:
            raise ValueError("Размерность должна быть 1 <= n <= 20")

        A = []
        for i in range(1, n + 1):
            row = lines[i].split()
            if len(row) != n:
                raise ValueError("Ошибка в матрице.")
            A.append([float(x) for x in row])

        b = [float(x) for x in lines[n + 1].split()]
        if len(b) != n:
            raise ValueError("Ошибка в векторе b.")

        eps = float(lines[n + 2])
        if eps <= 0:
            raise ValueError("Точность должна быть положительной.")

        return A, b, eps

    except FileNotFoundError:
        print("Файл не найден.")
        sys.exit(1)
    except Exception as e:
        print("Ошибка чтения файла:", e)
        sys.exit(1)


def is_diagonally_dominant(A):
    n = len(A)
    for i in range(n):
        if abs(A[i][i]) <= sum(abs(A[i][j]) for j in range(n) if j != i):
            return False
    return True


def make_diagonally_dominant(A, b):
    n = len(A)
    used = [False] * n
    current_perm = []

    def backtrack():
        if len(current_perm) == n:
            new_A = [A[i] for i in current_perm]
            new_b = [b[i] for i in current_perm]
            if is_diagonally_dominant(new_A):
                return new_A, new_b
            return None

        for i in range(n):
            if not used[i]:
                used[i] = True
                current_perm.append(i)

                result = backtrack()
                if result:
                    return result

                current_perm.pop()
                used[i] = False

        return None

    result = backtrack()
    if result:
        return result
    return None, None


def matrix_norm(A):
    return max(sum(abs(x) for x in row) for row in A)


def simple_iteration(A, b, eps, max_iter=10000):
    n = len(A)
    x = [0.0] * n
    x_new = x.copy()
    iterations = 0

    while iterations < max_iter:
        iterations += 1
        for i in range(n):
            s = sum(A[i][j] * x[j] for j in range(n) if j != i)
            x_new[i] = (b[i] - s) / A[i][i]

        errors = [abs(x_new[i] - x[i]) for i in range(n)]

        if max(errors) < eps:
            return x_new, iterations, errors

        x = x_new.copy()

    raise ValueError("Метод не сошелся за максимальное число итераций.")


def main():
    print("Выберите способ ввода:")
    print("1 - С клавиатуры")
    print("2 - Из файла")
    choice = input("Ваш выбор: ")

    if choice == '1':
        A, b, eps = input_from_keyboard()
    elif choice == '2':
        filename = input("Введите имя файла: ")
        A, b, eps = input_from_file(filename)
    else:
        print("Некорректный выбор.")
        sys.exit(1)

    if not is_diagonally_dominant(A):
        print("Диагонального преобладания нет. Выполняется попытка перестановки строк...")
        A, b = make_diagonally_dominant(A, b)
        if A is None:
            print("Невозможно достичь диагонального преобладания.")
            sys.exit(1)
        else:
            print("Диагональное преобладание достигнуто.")

    print("\nНорма матрицы:", matrix_norm(A))

    try:
        solution, iterations, errors = simple_iteration(A, b, eps)

        print("\nРешение:")
        for i, x in enumerate(solution):
            print(f"x{i + 1} = {x}")

        print("\nКоличество итераций:", iterations)

        print("\nВектор погрешностей:")
        for i, e in enumerate(errors):
            print(f"|x{i + 1}(k) - x{i + 1}(k-1)| = {e:.9f}")

    except Exception as e:
        print("Ошибка вычислений:", e)


if __name__ == "__main__":
    main()
