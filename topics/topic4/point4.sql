select count(*) / results.totals
from studentcourse
right join (
    select count(*) as totals, 0 as bonus
    from studentcourse where studentcourse.id_course = "1"
    ) results
    on 0 = results.bonus
where final_note >= "4" and studentcourse.id_course = "1";