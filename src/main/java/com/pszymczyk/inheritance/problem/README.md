Sklep internetowy sprzedaje ubrania - Wear. Produkty przetrzymywane są w magazynie - ClothesStorage.
W pierwszej iteracji zaimplementowano podstawową możliwość dodania ubrania do magazynu.

TODO:
1. Ze względu na pewne ograniczenia prawne w pewnych krajach nie możemy przechowywać w magazynie więcej niż 1000 sztuk ubrań.
W związku z tym należy dodać nowy typ magazynu rozszerzony o metodę zwracającą ilość ubrań znajdujących się w magazynie CountingClothesStorage.

!!!UWAGA!!!
Informacja o ilości sztuk w danym magazynie ma być bardzo szybka, decyzja o tym do którego magazynu dostarczyć ubranie
wywoływana będzie taśmowo przez system wybierający magazyn dla danego produktu, maksymalne opóźnienie zwrócenia informacji to 50ms.

2. Podczas dodawania produktu do magazynu należy sprawdzić czy ktoś oczekuje na taki produkt.
Jeżeli produkt jest na liście oczekiwanych (Wishlist) należy wysłać maila do oczekujacego (WaerAvailibilityNotifier).
Funkcjonalność ma być dostarczona do wszystkich magazynów (prostego i rozszerzonego).