# RDA-back-end
lesson5
class GetCategoryTest

getCategoryByIdPositiveTest - запрос данных по валидному и существующему ID, проверка возвращения корректных данных

getCategoryByIdNegativeTest - запрос данных по валидному,но несуществующему ID

class getProductsTest

getProductsTest - запрос всех продуктов, успешное получение списка с продуктами

class CreateProductPositiveTest

createProductInFoodCategoryTest - создание, модификация и поиск по ID  и удаление валидного продукта: - создан продукт с теми данными что мы указали;
- изменились данные коррректно;
- get-запрос отдал наш продукт;
- успешное удаление продукта.

class ProductNegativeTest

createProductInFoodCategoryNegativeTest1 - создание продукта  незаполненным названием - продукт создан

createProductInFoodCategoryNegativeTest2 - создание продукта - не заполнено ни одно поле - неуспешное создание

modifyProductInFoodCategoryNegativeTest1 - обновление продукта несуществующим ID 

modifyProductInFoodCategoryNegativeTest2 - частичное обновление (в JSON присутствуют не все поля)


getProductByIdNegativeTest - запрос продукта с несуществующим ID

deleteProductNegativeTest - удаление продукта с несуществующим ID
