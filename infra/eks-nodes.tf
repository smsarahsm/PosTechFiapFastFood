resource "aws_eks_node_group" "node_group" {
  cluster_name = aws_eks_cluster.cluster.name
  node_group_name = "nodeg-${var.project_name}"
  node_role_arn = var.role_lab
  subnet_ids = [aws_subnet.subnet_public[0].id,  aws_subnet.subnet_public[1].id, aws_subnet.subnet_public[2].id]
  tags = var.tags
  scaling_config {
    desired_size = 1
    max_size = 2
    min_size = 1
  }

  update_config {
    max_unavailable = 1
  }
}