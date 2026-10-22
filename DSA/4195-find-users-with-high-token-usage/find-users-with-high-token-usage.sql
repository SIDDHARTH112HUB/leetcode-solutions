/* Write your T-SQL query statement below */

select user_id, count(prompt) "prompt_count", ROUND(avg(tokens * 1.0),2) "avg_tokens"
from prompts
group by user_id
having count(*) >=3 
and Max(tokens) >avg(tokens * 1.0)
order by  ROUND(avg(tokens * 1.0),2)  desc
