-- Ejercicio 2
-- Listar el nombre del album de las canciones mayores a 5 minutos.
-- 

use spotify;

select albums.title from albums 
 inner join songs on 
  albums.id=songs.album && songs.duration>'5:00';