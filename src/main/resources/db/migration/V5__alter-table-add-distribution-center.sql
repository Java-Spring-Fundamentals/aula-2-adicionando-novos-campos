ALTER TABLE product ADD distribution_center TEXT;

UPDATE product SET distribution_center = 'RJ' WHERE category = 'clothes';
UPDATE product SET distribution_center = 'SP' WHERE category = 'electronics';
UPDATE product SET distribution_center = 'MG' WHERE category = 'home';
UPDATE product SET distribution_center = 'SP' WHERE distribution_center IS NULL;

ALTER TABLE product ALTER COLUMN distribution_center SET NOT NULL;

ALTER TABLE product ADD CONSTRAINT chk_product_distribution_center
    CHECK (distribution_center IN ('RJ', 'MG', 'SP'));

CREATE INDEX idx_product_distribution_center_active
    ON product (distribution_center, active);
