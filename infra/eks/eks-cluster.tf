resource "aws_eks_cluster" "cluster" {
  name = "eks-${var.project_name}"
  role_arn = var.role_lab
  vpc_config {
    subnet_ids = [aws_subnet.subnet_public[0].id, aws_subnet.subnet_public[1].id, aws_subnet.subnet_public[2].id]
  }
  tags = var.tags
  #access_config {authentication_mode = "API" }
}