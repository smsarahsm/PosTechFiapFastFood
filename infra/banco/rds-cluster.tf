resource "aws_rds_cluster" "aurora_cluster" {
  cluster_identifier      = "fiap-fastfood-aurora-v2"
  engine                  = "aurora-mysql"
  #engine_version          = "8.0.mysql_aurora.3.04.0"
  master_username         = "admin"
  master_password         = "admin123"
  database_name           = "fiapfastfood"
  db_subnet_group_name    = aws_db_subnet_group.aurora_subnet_group.name
  vpc_security_group_ids  = [aws_security_group.aurora_sg.id]
  skip_final_snapshot     = true
  tags = var.tags
}