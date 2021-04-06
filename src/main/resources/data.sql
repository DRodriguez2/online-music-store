insert into product(id, name, category, price) values (99, 'Welcome to the Jungle', 'MUSIC', 1.99);
insert into music(id, platform, type, artist, genre) values (99, 'DIGITAL', 'SONG', 'Guns n Roses', 'Rock');
insert into song(id) values (99);

insert into product(id, name, category, price) values (77, 'Appetite for Destruction', 'MUSIC', 5.99);
insert into music(id, platform, type, artist, genre) values (77, 'DIGITAL', 'ALBUM', 'Guns n Roses', 'Rock');
insert into album(id) values (77);

insert into song_album(song_id, album_id) values (99,77);