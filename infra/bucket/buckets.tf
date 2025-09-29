resource "aws_s3_bucket" "bucket-backend" {
  bucket = "postech-fiap-fastfood-backend-banco"
  tags   = var.tags
}