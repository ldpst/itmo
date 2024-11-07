from parser import parse_json
from parser.converter import convert_to_xml
from os import path

json = open(path.join(path.dirname(__file__), "../data/in-add3.json"), 'r').read()
xml = open(path.join(path.dirname(__file__), "../data/out-add3.xml"), 'w')
xml.write('<?xml version="1.0" encoding="UTF-8" ?>' + convert_to_xml(parse_json(json)))
