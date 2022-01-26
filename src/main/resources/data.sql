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

insert into Film (id, title, rating, watched, comments) values
                                                    (1, 'la venganza de los sith', 94, 1, 'la mejor peli omaigod iahbkhdbfkvhbafkvbjaksdv'),
                                                    (2, 'the rise of skywalker', 4, 1, 'la mpeor peli omaigod iahbkhdbfkvhbafkvbjaksdv'),
                                                    (3, 'rogue one', 54, 0, 'explota y mola   bkhdbfkvhbafkvbjaksdv');