def parse_json(json: str):
    string = parse_value(json.strip())[0]
    return string


def parse_string(string: str):
    if not string.startswith("\""):
        return None
    second_quote = string.find("\"", 1)
    if second_quote == -1:
        return None
    return string[1:second_quote], string[second_quote + 1:]


def parse_number(string: str):
    num = ""
    for i in string:
        if i in "0123456789.Ee-+":
            num += i
        else:
            break
    if num.isnumeric():
        return int(num), string[len(num):].strip()
    else:
        try:
            return float(num), string[len(num):].strip()
        except ValueError:
            return None


def parse_bool(string: str):
    if string.startswith("true"):
        return True, string[4:].strip()
    if string.startswith("false"):
        return False, string[5:].strip()


def parse_null(string: str):
    if string.startswith("null"):
        return None, string[4:].strip()


def parse_comma(string: str):
    if not string.startswith(','):
        return None
    return ",", string[1:].strip()


def parse_colon(string: str):
    if not string.startswith(":"):
        return None
    else:
        return ":", string[2:].strip()


def parse_array(string: str):
    if not string.startswith('['):
        return None
    parsed_comma_values = parse_comma_values(string[1:].strip())
    if parsed_comma_values is None:
        res, string = [], string[1:]
    else:
        res, string = parsed_comma_values
    if not string.startswith(']'):
        return None
    return res, string[1:].strip()


def parse_object(string: str):
    if not string.startswith("{"):
        return None
    arr, string = parse_comma_keyvalues(string[1:].strip())
    if not string.startswith("}"):
        return None
    return arr, string[1:].strip()
            

def parse_keyvalue(string: str):
    parsed_string = parse_string(string)
    if parsed_string is None:
        return None
    parsed_colon = parse_colon(parsed_string[1])
    if parsed_colon is None:
        return None
    parsed_value = parse_value(parsed_colon[1])
    if parsed_value is None:
        return None
    return (parsed_string[0], parsed_value[0]), parsed_value[1].strip()
    

def parse_comma_keyvalues(string: str):
    res = {}
    while True:
        parsed_keyvalue = parse_keyvalue(string)
        if parsed_keyvalue is None:
            break
        key, val = parsed_keyvalue[0]
        res[key] = val
        string = parsed_keyvalue[1]

        parsed_comma = parse_comma(string)
        if parsed_comma is None:
            break
        string = parsed_comma[1].strip()
    return res, string.strip()


def parse_value(string: str):
    parsed_number = parse_number(string)
    if not parsed_number is None:
        parse_value(parsed_number[1].strip())
        return parsed_number[0], parsed_number[1].strip()
    parsed_string = parse_string(string)
    if not parsed_string is None:
        parse_value(parsed_string[1].strip())
        return parsed_string[0], parsed_string[1].strip()
    parsed_bool = parse_bool(string)
    if not parsed_bool is None:
        parse_value(parsed_bool[1].strip())
        return parsed_bool[0], parsed_bool[1].strip()
    parsed_null = parse_null(string)
    if not parsed_null is None:
        parse_value(parsed_null[1].strip())
        return parsed_null[0], parsed_null[1].strip()
    parsed_array = parse_array(string)
    if not parsed_array is None:
        parse_value(parsed_array[1].strip())
        return parsed_array[0], parsed_array[1].strip()
    parsed_obect = parse_object(string)
    if not parsed_obect is None:
        parse_value(parsed_obect[1].strip())
        return parsed_obect[0], parsed_obect[1].strip()


def parse_comma_values(string: str):
    res = []
    while True:
        parsed_value = parse_value(string)
        if parsed_value is None:
            break
        res.append(parsed_value[0])
        string = parsed_value[1]

        parsed_comma = parse_comma(string)
        if parsed_comma is None:
            break
        string = parsed_comma[1]
    return res, string.strip()
