SELECT client.surname,client.name_of_client,client.patronymic,client.telephone_number,request_auto.request,request_auto.date_of_request,auto.mark
FROM client,request,request_auto,auto
WHERE client.client_id=request.client AND request.client=request_auto.request AND request_auto.auto=auto.number_id AND request_auto.date_of_request='24.10.2021'