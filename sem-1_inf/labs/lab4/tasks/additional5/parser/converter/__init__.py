def convert_to_tsv(d: dict, tag="root"):
    csv = "title\tgroup\tteacher/name\tteacher/id\tdate/day\tdate/weeks/0\tdate/weeks/1\tdate/weeks/2\tdate/weeks/3\tdate/weeks/4\tdate/weeks/5\tdate/weeks/6\tdate/weeks/7\tdate/weeks/8\tdate/weeks/9\tdate/weeks/10\tdate/weeks/11\tdate/weeks/12\tdate/weeks/13\tdate/weeks/14\tdate/weeks/15\ttime/lesson_number\ttime/start\ttime/end\troom/name\troom/id\tcampus/name\tcampus/id\tlesson_type/type_name\tlesson_type/type_id\tlesson_format/format_name\tlesson_format/format_id\n"

    for string in d["timetable"]:
        res = []
        res.append(string["title"])
        res.append(string["group"])
        res.append(string["teacher"]["name"])
        res.append(string["teacher"]["id"])
        res.append(string["date"]["day"])

        for i in string["date"]["weeks"]:
            res.append(str(i))
        for i in range(8 - len(string["date"]["weeks"])):
            res.append("\t")

        res.append(string["time"]["lesson_number"])
        res.append(string["time"]["start"])
        res.append(string["time"]["end"])
        res.append(string["room"]["name"])
        res.append(string["room"]["id"])
        res.append(string["campus"]["name"])
        res.append(string["campus"]["id"])
        res.append(string["lesson_type"]["type_name"])
        res.append(string["lesson_type"]["type_id"])
        res.append(string["lesson_format"]["format_name"])
        res.append(string["lesson_format"]["format_id"])

        csv += "\t".join(list(map(str, res))) + "\n"

    return csv
