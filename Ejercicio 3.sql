-- Ejercicio 3 
-- Mostrar el nombre del artista mas popular (mayor cantidad de plays).
-- 

use spotify;

Select artists.name from artists
 inner join songs on artists.id=songs.artist 
  where songs.plays =(select max(plays) from songs);

