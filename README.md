# Cagan-Bicakci-Odev6

## Coroutines

Öcelikle Coroutine'den bahsedecek olursak; Kotlin Coroutines, Android'de, Main Thread’i  bloklayabilecek ve uygulamamızın yanıt vermemesine neden olabilecek uzun süreli işlemleri yönetmemize yardımcı olan bir asenkron tasarım modelidir mevcut threadi bloklamadan askıya alınma işlevini sağlarlar.

![Screen Shot 2022-10-02 at 17 19 24](https://user-images.githubusercontent.com/44499663/193468294-1a11fd2c-147f-45d0-8904-144116c4c4a6.png)

Burada kullandığımız örnekte ise Uygulamın belli bir süre sonra çalıştığını ve sonrasında crash olduğunu gördük. Ama uygulama crash olmasına rağmen, counter main threadde çalışmaya devam etti. Daha farklı bir yaklaşımla burada uygulamanın crash olmasının önüne geçmek için, benzer şekilde uygulamayı zorlayacak veya main threadı şişirecek işlemleri aşağıdaki gibi async içerisinde kullanarak paralel process olarak çalışmasını sağlayabiliriz.

```
        while(true){

            CoroutineScope(Dispatchers.Main).async {
                count++
                Log.i("COUNT", count.toString())
            }

            CoroutineScope(Dispatchers.IO).launch {
                val answer = doNetworkCall()
                withContext(Dispatchers.Main) {
                    Log.v("PATIKA", answer)
                }
            }

        }
```

