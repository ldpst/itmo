from random import randint


def task(a):
    fib = [1, 2]
    while fib[-1] <= a:
        fib.append(fib[-1] + fib[-2])
    fib.pop()
    res = ""
    for i in range(len(fib) - 1, -1, -1):
        if fib[i] <= a:
            a -= fib[i]
            res += '1'
        else:
            res += '0'
    return res


def test():
    print(f"1. {192}(ФИБ) = {task(192)}")
    for i in range(9):
        t = randint(0, int(1e4))
        print(f"{i + 2}. {t}(ФИБ) = {task(t)}")


if __name__ == "__main__":
    test()
