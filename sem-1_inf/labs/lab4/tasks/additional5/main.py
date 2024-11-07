from parser import parse_json
from parser.converter import convert_to_tsv
from os import path

json = open(path.join(path.dirname(__file__), "../data/in.json"), 'r').read()
tsv = open(path.join(path.dirname(__file__), "../data/out-add5.tsv"), 'w')

tsv.write(convert_to_tsv(parse_json(json)))
