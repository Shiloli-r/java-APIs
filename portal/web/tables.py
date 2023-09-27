import django_tables2 as tables

class FieldsTable(tables.Table):
    id = tables.Column()
    policy_number = tables.Column()
    validation_request = tables.Column()
    date_created = tables.Column()
    validation_response = tables.Column()
    date_updated = tables.Column()