ALTER TABLE product ADD distribution_center TEXT;

UPDATE product
SET distribution_center = CASE
    WHEN category = 'clothes' THEN 'RJ'
    WHEN category = 'electronics' THEN 'SP'
    WHEN category = 'home' THEN 'MG'
    ELSE 'RJ'
END;

ALTER TABLE product
ALTER COLUMN distribution_center SET NOT NULL;