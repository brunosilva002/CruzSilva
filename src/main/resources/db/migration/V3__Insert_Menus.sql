/*
    Bruno Silva - 27-07-24
    Inserção dos dados de tabelas menus fixo
*/
INSERT INTO `barrel_type` VALUES (1,'Normal'),(2,'Rodeio');
INSERT INTO `gender` VALUES (1,'Masculino'),(2,'Feminino'),(3,'Indefinido');
INSERT INTO `gender_animal` VALUES (1,'Macho'),(2,'Femea');
INSERT INTO `reward_kind` VALUES (1,'Valor Fixo'),(2,'Subscrição');
INSERT INTO `roping_modality` VALUES (1,'3 Tambores',NULL),(2,'Laço',NULL),(3,'Laço em Duplas',NULL);
INSERT INTO `roping_status` VALUES (1,'Encerrado'),(2,'Aberto'),(3,'Em Execução');
INSERT INTO `roping_type` VALUES (1,'Cabeceiro'),(2,'Peseiro');
INSERT INTO `track_status` VALUES (1,'Liberado'),(2,'Bloquado');
INSERT INTO `type_classification` VALUES (1,'Classificação 1'),(2,'Classificação 2'),(3,'Classificação 3'),(4,'Classificação 4'),(5,'Semi Final'),(6,'Final');
INSERT INTO `type_classification_time` VALUES (1,'Melhor Tempo'),(2,'Média do Tempo'),(3,'Somatorio do Tempo');
INSERT INTO payment_type (`cdn_payment_type`,`creation_date`,`creation_user`,`name`,`update_date`,`update_user`) VALUES (1,NULL,NULL,'Dinheiro',NULL,NULL);
INSERT INTO payment_type (`cdn_payment_type`,`creation_date`,`creation_user`,`name`,`update_date`,`update_user`) VALUES (2,NULL,NULL,'PIX',NULL,NULL);
INSERT INTO payment_type (`cdn_payment_type`,`creation_date`,`creation_user`,`name`,`update_date`,`update_user`) VALUES (3,NULL,NULL,'Cartão de Débito',NULL,NULL);
INSERT INTO payment_type (`cdn_payment_type`,`creation_date`,`creation_user`,`name`,`update_date`,`update_user`) VALUES (4,NULL,NULL,'Cartão de Crédito',NULL,NULL);
INSERT INTO payment_type (`cdn_payment_type`,`creation_date`,`creation_user`,`name`,`update_date`,`update_user`) VALUES (5,NULL,NULL,'Cheque',NULL,NULL);
INSERT INTO payment_type (`cdn_payment_type`,`creation_date`,`creation_user`,`name`,`update_date`,`update_user`) VALUES (6,NULL,NULL,'Transferencia',NULL,NULL);
INSERT INTO payment_type (`cdn_payment_type`,`creation_date`,`creation_user`,`name`,`update_date`,`update_user`) VALUES (7,NULL,NULL,'Cortesia',NULL,NULL);
INSERT INTO payment_type (`cdn_payment_type`,`creation_date`,`creation_user`,`name`,`update_date`,`update_user`) VALUES (8,NULL,NULL,'Permuta',NULL,NULL);

