/* 데이터를 특정 컬럼을 기준으로 그룹으로 묶어 질의하기
=> group by ~ having ~
*/

/* 각 지점별 강의실 수 구하기*/
-- 1단계
select 
    r.rno,
    r.loc,
    r.name
from
    room r

-- 2단계 그룹으로 묶인 경우 그 그룹의 첫번째 값만 저장
select 
    r.rno,
    r.loc,
    r.name
from
    room r
group by loc;

-- 3단계 group by로 묶고 개별 항목 값은 의미 없음
select 
    r.loc
from
    room r
group by loc;

--
select 
    r.loc,
    count(*) as number_loc
from
    room r
group by r.loc;

--
select 
    r.loc,
    count(*) as number_loc
from
    room r
group by 
    r.loc
having
    r.name = '301';