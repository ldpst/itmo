from time import time
from os import path
from main_task.parser import parse_json as pj1
from main_task.parser.converter import convert_to_xml as cx1
from additional1.main import convert_to_xml as cx2
from additional1.main import parse_json as pj2
from additional2.parser import parse_json as pj3
from additional2.parser.converter import convert_to_xml as cx3
from additional3.parser import parse_json as pj4
from additional3.parser.converter import convert_to_xml as cx4


def test(converter, parser, string):
    stime = time()
    for i in range(100):
        converter(parser(string))
    return time() - stime


if __name__ == '__main__':
    json = open(path.join(path.dirname(__file__), "../data/in.json")).read()
    json1 = open(path.join(path.dirname(__file__), "../data/in-add3.json")).read()
    print(f"Собственный: {test(cx1, pj1, json)}")
    print(f"Собственный c регулярными: {test(cx2, pj2, json)}")
    print(f"С библиотеками: {test(cx3, pj3, json)}")
    print(f"Собственный полный: {test(cx4, pj4, json1)}")
