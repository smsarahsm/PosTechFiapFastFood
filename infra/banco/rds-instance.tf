resource "aws_rds_cluster_instance" "aurora_instance" {
  identifier              = "fiap-fastfood-aurora-instance-1"
  cluster_identifier      = aws_rds_cluster.aurora_cluster.id
  instance_class          = "db.t3.medium"
  engine                  = aws_rds_cluster.aurora_cluster.engine
  engine_version          = aws_rds_cluster.aurora_cluster.engine_version
  publicly_accessible     = true
  tags = var.tags
}