/*
    Bruno Silva - 27-07-24
    Inserção dos dados de tabelas menus fixo
*/
CREATE VIEW `city_estate` AS
SELECT a.*, b.name as name_estate
FROM easy_roper2.city 			a
inner join easy_roper2.estate	b on a.cdn_estate=b.cdn_estate