# Write your MySQL query statement below
SELECT a.machine_id, ROUND(AVG(act.timestamp-a.timestamp), 3) as processing_time 
FROM Activity a
JOIN Activity act ON a.machine_id = act.machine_id
WHERE a.activity_type = 'start' AND act.activity_type='end'
GROUP BY a.machine_id;