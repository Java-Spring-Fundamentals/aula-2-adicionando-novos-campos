ALTER TABLE product
ADD COLUMN distribution_center VARCHAR(2);

UPDATE product
SET distribution_center =
    CASE
        WHEN category = 'clothes' THEN 'RJ'
        WHEN category = 'electronics' THEN 'SP'
        WHEN category = 'home' THEN 'MG'
        ELSE 'SP'
    END;

ALTER TABLE product
ALTER COLUMN distribution_center SET NOT NULL;

ALTER TABLE product
ADD CONSTRAINT check_product_distribution_center
CHECK (distribution_center IN ('RJ', 'MG', 'SP'));