--Delete the duplicate rows from the table
DELETE FROM india_states
WHERE rowid not in
(SELECT MIN(rowid)
FROM india_states
GROUP BY MDDS_STC, STATE_NAME, MDDS_DTC, DISTRICT_NAME, MDDS_SUB_DT, SUB_DISTRICT_NAME, MDDS_PLCN, AREA_NAME);