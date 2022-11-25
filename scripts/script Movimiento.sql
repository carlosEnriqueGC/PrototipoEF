CREATE TRIGGER `Ingreso` AFTER INSERT ON `tbl_movimientode`
 FOR EACH ROW insert into tbl_bitacora (bitfecha, bitaccion, usuid, aplid, bitip, bitnombrepc) VALUES (CURRENT_DATE(), "insert", 4, 7, "192.1.100.1",  CURRENT_USER())
