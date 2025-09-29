terraform {
  backend "s3" {
    bucket = "postech-fiap-fastfood-backend-eks"
    key    = "backend/tfstate/terraform.tfstate"
    region = "us-east-1"
  }
}
