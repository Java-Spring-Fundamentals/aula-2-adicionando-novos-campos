ALTER TABLE product ADD distribution_center TEXT;

UPDATE product SET distribution_center = 'RJ' WHERE category = 'clothes';
UPDATE product SET distribution_center = 'SP' WHERE category = 'electronics';
UPDATE product SET distribution_center = 'MG' WHERE category = 'home';
