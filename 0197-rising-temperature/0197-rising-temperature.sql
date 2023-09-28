# Write your MySQL query statement below
SELECT ws.id
FROM Weather w
JOIN Weather ws ON DATEDIFF(w.recordDate, ws.recordDate) = -1
AND ws.temperature > w.temperature;