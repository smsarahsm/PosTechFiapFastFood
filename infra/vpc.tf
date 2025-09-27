resource "aws_vpc" "fiap_fastfood_vpc" {
  cidr_block           = var.cidr_block_vpc
  enable_dns_hostnames = true
  enable_dns_support   = true
  #main_route_table_id = aws_route_table.route_table_public.id
  tags = var.tags
}