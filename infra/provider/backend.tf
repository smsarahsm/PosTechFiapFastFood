terraform {
  backend "s3" {
    bucket = "postech-fiap-fastfood-backend"
    key    = "backend/tfstate/terraform.tfstate"
    region = "us-east-1"
  }
}
