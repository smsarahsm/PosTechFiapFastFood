resource "aws_db_subnet_group" "aurora_subnet_group" {
  name       = "aurora-subnet-group"
  subnet_ids = [aws_subnet.subnet_public[0].id, aws_subnet.subnet_public[1].id, aws_subnet.subnet_public[2].id]
  tags = var.tags
}