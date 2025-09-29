output "aurora_endpoint" {
  value = aws_rds_cluster.aurora_cluster.endpoint
}

output "aurora_reader_endpoint" {
  value = aws_rds_cluster.aurora_cluster.reader_endpoint
}