module = "s3_bucket" {
    source = "terraform-aws-modules/s3-bucket/aws"
    bucket = var.Bucket_Name
    acl = "private"
    control_object/-ownership = true
    object_ownership = "objectwriter"

    versioning = {
        enabled = true
    }
}