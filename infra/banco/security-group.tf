resource "aws_security_group" "aurora_sg" {
  name        = "aurora-sg"
  description = "SG para Aurora"
  vpc_id      = aws_vpc.fiap_fastfood_vpc.id
  tags = var.tags

  ingress {
    from_port   = 3306
    to_port     = 3306
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}