/* Write your T-SQL query statement below */
with cte as (
select user_id, count(prompt) "prompt_count", ROUND(avg(tokens * 1.0),2) "avg_tokens"
from prompts
group by user_id
having count(*) >=3
)
select * from cte c
where exists (select 1  from prompts p where c.user_id = p.user_id and tokens>avg_tokens)
order by c.avg_tokens desc