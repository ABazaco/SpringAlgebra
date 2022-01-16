insert into users (username, password, enabled) values
                                                    ('admin', 'pass', 1),
                                                    ('user', 'pass', 1);

insert into authorities (username, authority) values
                                                  ('admin', 'ROLE_ADMIN'),
                                                  ('user', 'ROLE_USER');

insert into questions (id, title, body) values
                                         (1, 'First Question', 'kajsdkgjansddkjnakdsjnfkajsdnfkajsdfkasdjnfaksdjnfaksjdfnaksdjfnsadadsjhfbaksjdb kaehrgoadnfognja aofihgshf'),
                                         (2, 'Second Question', 'k adsfgossdfkasdjnfaksdjnfaksjdfnaksdjfnsadadsjhfbaksjdb kaehrgoadnfognja aofihgshf'),
                                         (3, 'Third Question', ' nfkajsdnfkajsdfkasdjnfaksdjnfaksjdfnaksdjfnsadadsjhfbaksjdb kaehrgoadnfognja aofihgshf');

