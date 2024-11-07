from json import loads
from os import path
from dicttoxml import dicttoxml


def convert_to_xml(json_data):
    xml = dicttoxml(json_data, attr_type=False, return_bytes=False)
    return xml


def parse_json(string: str):
    json_data = loads(string)
    return json_data


if __name__ == "__main__":
    json = open(path.join(path.dirname(__file__), "../data/in.json"), 'r').read()
    xml = open(path.join(path.dirname(__file__), "../data/out-add1.xml"), 'w')
    xml.write(convert_to_xml(parse_json(json)))
