drop database if exists alcometer;
create database alcometer;
use alcometer;


create table dishes(
	dishes_id int primary key,
    first_dish varchar(128),
    second_dish varchar(128),
    third_dish varchar(128));
    
    
create table drinks(
	drinks_id varchar(8) primary key,
    type varchar(24),
    description varchar(2048));
    
create table drinks_dishes(
	dishes_id int,
    drinks_id varchar(8),
    primary key (dishes_id, drinks_id),
    foreign key (dishes_id) references dishes (dishes_id),
	foreign key (drinks_id) references drinks (drinks_id));
    
    
create table users(
	user_id varchar(24) primary key);
    
create table history(
	history_id int primary key auto_increment,
    volume int,
	user_id varchar(24),
    type varchar(24),
    date datetime,
    foreign key (user_id) references users (user_id));

    
    
insert into users values
	('abc'),
    ('qwe');
    
    
insert into dishes values
	(1, 'fish','white','sea'),
    (2, 'fish','white','freshwater '),
    (3, 'fish','red','sea'),
    (4, 'fish','red','freshwater '),
    (5, 'fish','salty',null),
    (6, 'seafood','crayfish',null),
    (7, 'seafood','oysters',null),
    (8, 'seafood','squid',null),
    (9, 'beef','steak','rare'),
    (10, 'beef','steak','medium_rare'),
    (11, 'beef','steak','well_done'),
    (12, 'beef','stew',null),
    (13, 'beef','spicy',null),
    (14, 'mutton','steak',null),
    (15, 'mutton','barbecue',null),
    (16, 'mutton','spicy',null),
    (17, 'fowl','creamy',null),
    (18, 'fowl','spicy',null),
    (19, 'fowl','chops',null),
    (20, 'fowl','turkey',null),
    (21, 'fowl','duck',null),
    (22, 'cheeses','hard',null),
    (23, 'cheeses','soft',null),
    (24, 'cheeses','mold',null),
    (25, 'fruits','grape',null),
    (26, 'fruits','pear',null),
	(27, 'nuts',null,null),
	(28, 'dessert','farinaceous','cupcakes'),
	(29, 'dessert','farinaceous','pies'),
	(30, 'dessert','farinaceous','cakes'),
	(31, 'dessert','sugarless',null),
	(32, 'dessert','ice_cream',null);
    
    
insert into drinks values
	('БС', 'Белое сухое', 'Белые сухие вина получают из винограда, с которого предварительно была снята кожица,это могут быть и красные сорта. Виноделы чаще всего используют такие сорта, как Мускат, Шардоне, Вернача, Рислинг, Греко, Токай, СовиньонБлан, ПиноБлан, Грюнер, Требианно, Марсанн.
Поскольку белое сухое вино является достаточно легким напитком, его применение требует таких же простых и нежных блюд. Идеальными сочетаниям в подобной ситуации будут рыбные деликатесы, птица или свежие фрукты. При этом такие достаточно тяжелые и калорийные продукты, как жареное мясо или разнообразная выпечка вряд ли придутся по вкусу с этим вином.
 Несовместимы с сухим белым вином продукты: цитрусовые, шоколад, орехи и сильно пряные кулинарные изделия и блюда со вкусом уксуса.
 Подают белое вино охлажденным до 10-12 градусов, чтобы его свежий вкус полностью раскрылся. При подаче белого вина его наливают в бокал на две трети.'),
    ('БП', 'Белое полусухое', 'Белым полусухим вином принято называть вино столовое, в котором содержание спирта варьируется в пределах 9-13 процентов, в то время как количество сахара бывает от 5 до 25 граммов на дм.куб. Традиционные сорта винограда: Шардоне, Рислинг, Гевюрцтраминер, Шабли. В отличие от сухих вин, оно оставляет приятное сладкое послевкусие и имеет умеренную кислотность.
Белое полусухое вино является идеальным аперитивом. Вино хорошо сочетается с блюдами из нежирной рыбы, за исключением сельди. К нему так же идеально подходят блюда из птицы и дичи, заправленные легким соусом. Сыры, морепродукты, фрукты, овощи, орехи — все это будет прекрасно гармонировать. Но стоит избегать слишком жирных или пряных блюд в сочетании с виноградным напитком, особенно, если они приправлены мятой или карри. 
Для еще более яркого и полного вкуса белое полусухое вино должно отличаться определенной температурой 10-12 градусов, при этом в летнее время года температуру можно дополнительно снизить на пару градусов. '),
    ('БПС', 'Белое полусладкое', 'Лучшие полусладкие (некрепленые) вина производит Франция, Италия и Австрия. Также стоит отметить вина Грузии, но здесь легко попасть на подделку.  Полусладкие вина не могут стоить дешево, так как технология их приготовления сложнее, чем у сухих вин!
Полусладкое вино хорошо подавать к морепродуктам (крабы, устрицы и раки), а также к различным овощным блюдам (цветная капуста, зеленый горошек и др.). Вообще белые полусладкие вина хорошо сочетаются с рыбой под островатым соусом, белым мясом птицы и телятины, нежными сырами, паштетами и колбасами. Главное, при выборе закуски к белому полусладкому вину – это не затмить его тонкий аромат. Избегайте пряных и острых трав с характерным запахом. 
Для еще более яркого и полного вкуса белое полусладкое вино должно отличаться определенной температурой 10-12 градусов, при этом в летнее время года температуру можно дополнительно снизить на пару градусов. '),
    ('КС', 'Красное столовое', 'Столовые вина получили свое наименование в связи с тем, что в винодельческих районах они являются винами ежедневного потребления, постоянной и привычной принадлежностью стола. Эти вина называют еще и сухими потому, что сахар винограда в них перебродил досуха. Традиционные сорта для производства: Саперави, Каберне, Мукузани, Зинфандель.
Красные ординарные вина подают к мясу: баранине, говядине, свинине, дичи или домашней птице. То есть классическим считается сочетания красного вина с красным мясом (говядина, баранина, утка, тунец). Красное столовое вино подается чаще всего к простым блюдам или блюдам со специями, так как само по себе не является «главой стола» и не требует раскрытия вкуса. 
Столовое вино подают температурой на несколько градусов ниже комнатной. Некоторые сорта, например, "Каберне", должны иметь температуру не ниже 15-16 градусов. Если такое вино хранилось в холодильнике, то его непременно следует подогреть до указанной температуры.'),
    ('КСЛ', 'Красное Сухое Легкое', 'Легкие вина – те, которые не выдерживают в дубовых бочках. Их сбраживают и сразу разливают в бутылки. Все молодые вина – легкие. Так же, как и все розовые. У них освежающая кислотность, низкий уровень алкоголя, прямой аромат и вкус. Традиционные сорта винограда: КабернеСовиньон, ПиноНуар, Божоле, Ламбруско, Шпэтбургундер
Красные вина подходят к говядине, свинине, дичи и жирной птице (гусь, индейка). И помните, чем плотнее и насыщеннее вкус блюда, тем более насыщенным должно быть вино! Таким образом, сухое легкое вино будет хорошо сочетаться с простыми нетяжелыми блюдами, а также сливочными сырами и сырами с белой и голубой плесенью. 
Красное легкое вино подают температурой 12-15 градусов. '),
    ('КСН', 'Красное сухое насыщенное', 'Вина средней плотности могут быть нескольких разновидностей. Первая – южные вина. Виноград, выросший под палящим солнцем, содержит в кожице и косточках природный танин. Второй вариант – вина, выдержанные в старых бочках, которые уже отдали основную часть танина. Процесс производства мощных плотных вин связан с выдержкой в дубе, продолжительность которой колеблется от нескольких месяцев до двух лет. Из дуба в вино всасываются танины, структура становится более плотной, вкус насыщенным. Традиционные сорта: Мерло, Мальбек, Пиногрижио, Шираз, Сирах, Карменер
К пище с более ярким и сильным вкусом нужны такие же вина, мощные, с характером, ну а более деликатные блюда требуют таких же легких вин. Поэтому к красному мясу – стейкам, тушеному мясу вроде говядины по-бургундски, ростбифу, дичи, баранине, твердым сырам –лучше всего подходят ароматные, танинные вина. Кроме того, в красном вине содержатся вещества, способствующие более быстрому расщеплению жиров.  Любое красное сухое вино подается с температурой не ниже 18 градусов. Это - неоспоримое правило. Иначе вкус вина потеряется.'),
    ('КСлд', 'Красное сладкое вино', 'Красные сладкие вина большая редкость для России. Такое вино НИКОГДА не продается в бутылках объемом более 0,5л и не может стоит дешевле 2-3 тысяч рублей. Хотя есть модификации таких вин с добавлением спирта и сахара (крымская Мадера, например). Такие ограничения связаны со сложностью производства такого вина. Предварительно виноград высушивается на солнце до состояния изюма, что позволяет при изготовлении увеличить количество сахара.
Традиционные сорта: Мускат, Мадера, Херес
Такое вино сложно с чем-либо сочетать. Чаще всего его потребляют как аперитив. Однако такое вино может хорошо сочетаться со стейками из баранины или острыми и голубыми сырами. Также вино подходит к несладким десертам.
Такое вино обычно подают в специальных бокалах, объемом меньше традиционных. Температура подачи 18-20 градусов.'),
    ('БД', 'Белое Десертное', 'Белое десертное вино – разновидность крепленых сладких вин, содержание спирта в нем достигает 17%. Эти вина считаются более сахаристыми, чем крепкие вина. Для производства белого десертного вина используют наиболее сладкие сорта винограда. Его производят путем брожения спирта на основе виноградного сока. 
Фирмы, производящие лучшие десертные вина: Сотерн, Токайские вина, вина Массандры, вина Ундурага.
Десертные вина употребляют только ради наслаждения их вкусом. Такие вина принято пить после застолья для того, чтобы не перебивать их тонкий вкус и аромат даже самой изысканной пищей. 
Белое десертное вино само по себе является десертом. Но если все же хочется с чем-то его сочетать, то подойдут пирожные и торты, а также мягкие фрукты.
Подавать десертное вино необходимо в специальных «мадерных» рюмках температурой 10-16 градусов.'),
    ('КД', 'Красное Десертное', 'Красное десертное вино, как правило, готовят из темных сортов винограда. К ним можно отнести: Саперави, Изабеллу, Каберне и чёрный Мускат. Готовый напиток имеет насыщенный красный цвет и приятный характерный аромат. Такое вино немного густое и довольно сладкое на вкус. Такое вино выстаивается в бочках не менее трех лет.
Десертные вина сочетаются с фруктами и фруктовыми салатами, орехами, печеньем, тортами и другими сладостями. Но десерт должен быть более сладким, чем само вино. Также вино хорошо подходит к «крепким» сырам. 
Температура подачи: 16-20 градусов'),
    ('КВ', 'Крепленое вино', 'Крепленое вино отличается от обычных тем, что при изготовлении в сусло добавляют спирт. Таким образом градус крепленого вина может составлять 15-25%.
Самые известные виды крепленого вина: Портвейн, Мадера, Херес, Марсала, Вермут.
В качестве закуски могут быть поданы фрукты, мороженое, десерты, кондитерские изделия, сладкая выпечка, острые  и плесневые сыры. Крепкие вина обычно подают к первым блюдам и жирным, «плотным» мясным кушаньям и, как ни странно, соленой красной рыбе. Исключение составляет марсала: сухая марсала подается как аперитив, сладкая – в качестве десертного вина. Херес и мадера хорошо подходят к супам-пюре и бульонам.  
Крепленые вина обычно подаются комнатной температуры, хотя современное видение данного напитка позволяет подавать его и со льдом. Кстати, мадеру и херес принято подогревать на 4-5С выше комнатной температуры). 
Наиболее распространены в России портвейны, мадеры и хересы фирм Массандра, Valdouro, PedroXimenez.'),
    ('И', 'Игристое вино', 'Игристое — это по своей сути насыщенное углекислым газом вино, а технология, с помощью которой газ появляется — едва ли не основное отличие дорогих бутылок от дешёвых. Традиционное шампанское и все его подражатели — это в большинстве белые вина. Белые шампанские могут делать из смеси шардоне, пино нуара и пино менье, или на 100% из одного сорта.
Шампанское классифицируется по содержанию сахара: • Extra Brut — сахар отсутствует полностью • Brut — от 0 до 15 г/л • Extra sec — очень сухое, 12-20 г/л • Sec — сухое, 17-35 г/л • Demi-sec — полусухое, от 33 до 50 г/л • Doux — сладкое, свыше 50 г/л.
Игристое вино традиционно сочетается с фуа-гра, фруктами, орехами, мороженым, козьими сырами. Сладкие сорта игристого также сочетаются с десертами.
Подают игристые вина исключительно ледяными в специальных узких бокалах:5-8 градусов.
Известные фирмы: испанские Кава, французский Cremant, Asti Mondoro, «Cinzano» Prosecco, Piper-Heidsieck, Moët & Chandon.'),
    ('Ш', 'Шампанское', 'Шампанское – уникальный вид игристого вина. Шампанскими имеют право называться только те вина, что произведены в регионе Франции Шампань. Все остальные игристые вина, будь они приготовлены резервуарным методом или по традиционной технологии, имеют собственные названия.
Шампанское идеально сочетается с икрой, устрицами, прошутто, некоторыми голубыми сырами.
Подают шампанское ледяным: около 5-7 градусов.'),
    ('В', 'Виски', 'Виски – крепкий алкогольный напиток (от 40%), который получают из ячменя, пшеницы, кукурузы или других зерновых. Главные производители виски - это Шотландия и Ирландия. 
В иски имеет множество классификаций, но главная одна: Виски бывает купажированный (blended) и односолодовый (single malt). Купажированный получают путем смешивания различных сортов зерновых. Такой виски обычно дешевле, чем односолодовые. Самый идеологический чистый виски - односолодовый (single malt) виски, произведённый из одного сорта зерна, иногда смешивают разные годы выдержки одного сорта.  Также огромное значение имеет происхождение виски. Например, виски произведенные на острове Айла, разительно отличаются от собратьев торфяным вкусом.
Виски хорошо сочетается с тяжелыми и жирными блюдами, особенно с пряной бараниной и говядиной. Также его можно подавать к мучным десертам и некоторым твердым сырам. Подают виски комнатной температуры. 
Обычные купаж: Jameson, Tullamore Dew, Bushmills. 
Обычные односолод: Macallan, Balvenie,  Silver seal
Островные:Ardbeg, Bowmore, Lagavulin, Laphroaig'),
    ('Р', 'Ром', 'Ром - недорогой крепкий напиток на основе сахарного тростника. 
Цвет рома зависит от срока его выдержки в бочке (а соответственно и цена). Обычно ром используют для изготовления коктейлей, поскольку это недорогой напиток. Но есть вариации употребления его в чистом виде, что особенно актуально в северных регионах.
Белый ром используют исключительно для коктейлей. Темный ром хорошо сочетается с мучными десертами, кофе, шоколадом.
Температура подачи рома может быть любой, здесь нет особых правил. Но классическим вариантом считается ром со льдом.
Наиболее распространенные марки в России: Bacardi, Barcelo, Captain Morgan, Contrabando.'),
    ('К', 'Кальвадос', 'Кальвадос – крепкий напиток на основе яблок родом из Нормандии. По сути это очень выдержанный сидр (технология производства почти одинакова). 
Кальвадос - напиток, который имеет разную выдержку. Время делает из прозрачной жидкости темно-янтарный напиток с густым ароматом. Срок выдержки в обязательном порядке указывается на этикетках бутылок и имеет свою специфику: выдержка от 2 лет – «Fine»; выдержка от 3 лет – «Vieux-Reserve»; больше 4 лет – «V.O. » (Very Old), «V.S.O.P.» (Very Superior Old Pale); больше 6 лет – «X.O.» (Extra Old), «Extra»; 
Кальвадос хорошо сочетается с фруктами, сырами и яблочными десертами ( особенности) и фруктовыми соусами. 
Подавать кальвадос следует в широких бокалах комнатной температуры, перед употреблением его необходимо погреть в ладонях.
Распространенные фирмы-производители в России: Pere Magloire, Calvados Pierre Huet'),
    ('Д', 'Джин', 'Джин— это крепкий напиток, который готовиться из забродившего зернового сырья, которое в дальнейшем проходит двойную дистилляцию с ягодами можжевельника и прочими пряностями. Имеет ярко выраженный можевеловый вкус. 
Джин хорошо сочетается с тоником и льдом, а также с обычной минералкой – она максимально раскрывает аромат напитка. Также возможен вариант употребления джина.
Поскольку у джина яркий специфический вкус, не стоит его сочетать с такими же яркими блюдами, особенно со специями. В остальном джин хорошо сочетается с любыми блюдами. Но в классическом варианте – джинн-аперитив, а значит не требует закуски. 
Самые известные марки джина: Beefeater, Bombay Sapphire, Gordons'),
    ('Лаг', 'Пиво Лагер', 'Лагер – общее название многочисленных сортов пива низового брожения (ферментации при низкой температуре). В настоящее время по этой технологии производится около 80% пива в мире. Популярность лагера объясняется более мягким в отличие от эля вкусом, длительным сроком хранения без ухудшения вкусовых качеств и возможностью транспортировки на большие расстояния. 
Лагер имеет мягкий пшеничный или ячменный вкус, иногда горьковатый. Лагер универсальное пиво и сочетается абсолютно со всеми блюдами. Температура подачи от 7 до 10 градусов.
Хороших марок лагера огромное множество, но особенно хороши немецкие, голландские и американские лагеры, например, Spaten, Budweiser, Pilsner'),
    ('Пш', 'Пиво Пшеничное', 'Пшеничное или белое пиво – это слабоалкогольный напиток, в основе которого лежит пшеница. Благодаря этому пшеничное пиво имеет свой уникальный желтовато-белый цвет и свой свежий пшеничный вкус. 
Пшеничное пиво может быть фильтрованный и нефильтрованным. Кстати осадок в нефильтрованном варианте – это признак качества и натуральности. Из-за своего спокойного вкуса пшеничное пиво сочетается с любыми блюдами, а бельгийские сорта особенно хорошо с десертами. Это один из немногих напитков, сочетаемый с пряными и острыми блюдами.
Подавать его следует температурой 7-10 градусов. Чем темнее пиво, тем теплее оно должно быть. 
Наиболее качественные марки, представленные в России: Franziskaner, Paulaner, Schneider.'),
    ('Пр', 'Портер', 'Пиво Портер — тёмное пиво с характерным винным или кофейным привкусом, сильным ароматом солода и насыщенным вкусом, в котором одновременно присутствуют и сладость, и горечь. Крепость может сильно разниться от 5% до 15% градусов. Классические варианты имеют градус алкоголя около 6-7%. 
У портера яркий необычный вкус, поэтому не стоит его употреблять с сухариками, орешками (кешью исключение), сушеной рыбой, чипсами и прочими традиционным русскими пивными закусками. Почти все эти закуски портят вкус пива, не давая ему раскрыться. Портер хорошо сочетается с десертами, сырами и, особенно пломбиром. Подавать портер следует исключительно комнатной температуры.
Отличные марки портера: London Porter, Fullers, Афанасий, Old engine oil'),
    ('Ст', 'Пиво Стаут', 'Стаут – особенный вид пива, сваренный на основе хмеля, воды, дрожжей и жареного ячменя или жженого солода. Сегодня пиво стаут – это плотный темный эль с густой кремовой пеной, горьковатым вкусом с кофейно-шоколадными тонами и бодрящим эффектом – еще в XIX-XX веках врачи нередко прописывали пинту Гиннесса больным, донорам крови и даже кормящим матерям.
Стаут идеально сочетается с мидиями и устрицами (иногда его называют устричным пивом). Также стаут хорошо подходит к шоколадным десертам, кофе, твердым сырам, а также различным стейкам. Самое важное не перебивать вкус специями. Подавать следует, как и портер, исключительно комнатной температуры.
Идеальные марки стаута: Guiness, KBS, Sierra Nevada Stout, Иван Кожедуб, Inner Demons.'),
    ('Э', 'Эль', 'Эль— сорт пива, отличающийся тонким фруктовым привкусом и высоким содержанием спирта (3-12%). От обычного пива классический эль отличается отсутствием хмеля в рецептуре. Благодаря этому он готовится быстрее и узнается по выраженному сладковатому оттенку. Вкусовой букет формируется травами и специями, которые вывариваются в сусле вместо хмеля. Готовый продукт не подвергают дальнейшей пастеризации или фильтрованию, поэтому зачастую он мутный. 
Видов эля великое множество. Однако наиболее интересные сорта производит Британия и Бельгия. 
С чем употреблять эль зависит от его вида. Простые сорта сочетаются и с мясом, и с десертами, и с сырами. Кислые виды типа Барлевайна сочетаются только со сладкими блюдами. Бельгийские эли не принято употреблять с тяжелыми блюдами, изысканный вкус требует более нежных сочетаний.
Распространенные марки и сорта: ирландский Ohara, бельгийские эли, Hoegaarden.'),
    ('Лам', 'Ламбик', 'Ламбик – вид эля, требующий отдельного рассмотрения в силу своей огромной популярности. Ламби́к — вид бельгийского пива. Готовится методом самопроизвольного брожения в бочках, которые использовались ранее для выдержки вин. Настоящий ламбик имеет зерново-яблочный вкус и аромат и не содержит посторонних добавок.
Мягкость и изысканность вкуса сделала ламбик популярным напитком среди девушек. Кстати излюбленное девичье вишневое пиво – в абсолютном большинстве производится с добавлением сока. В то время как настоящий вишневый ламбик (Крик) приобретает свой вкус путем сбраживания зерна вместе с солодом. 
Идеальные ламбики: Liefmans, Chimay, Rochefort'),
    ('Ипа', 'Пиво India Pale Ale', 'Пивовары искали такие способы доставки пенного напитка к далеким берегам, при которых он не терял бы изначального качества, ведь повышенные температуры и постоянная качка влияли на свойства пива не лучшим образом. В результате подобных экспериментов и появилось пиво IPA, отличительной особенностью которого стало повышенное содержание хмеля.  Из-за высокого содержания хмеля данный сорт пива имеет специфический очень горький вкус, который сначала вызывает негативные эмоции. Но потом кроме Ipa для вас не существует других сортов=)
Напиток достаточно крепкий, от 6%.
Из-за своей горечи такое пиво вряд ли будет сочетаться с изысканными блюдами или рыбой. Зато отлично подходит к английской и американской кухне (фиш энд чипс, бургеры, фри). Если не хочется ничем портить вкус ипы, но закусывать надо (а закусывать надо, ибо это «опасный» сорт пива, вызывающий быстрое опьянение), выбирайте орехи, лучше всего кешью.
В настоящее время этот сорт пива один из популярнейших в мире, и варить его не так уж сложно, поэтому сортов великое множество, например: Sierra Nevada, Old engine oil, Af Brew, Saldens, Jaws');

insert into drinks_dishes values
	(1,'БС'),
    (1,'БП'),
    (2,'КС'),
    (2,'БП'),
    (3,'КСЛ'),
    (3,'КСН'),
    (4,'КСЛ'),
    (4,'БС'),
    (4,'КС'),
    (5,'КВ'),
    (6,'Лаг'),
    (6,'Пш'),
    (6,'БС'),
    (7,'И'),
    (7,'Ш'),
    (7,'Ст'),
    (8,'Р'),
    (8,'Лам'),
    (9,'КС'),
    (9,'КСЛ'),
    (10,'КСН'),
    (10,'КСЛ'),
   -- (10,'КСН'),
    (10,'КД'),
    (11,'КСН'),
    (11,'КД'),
    (11,'ПШ'),
    (12,'КС'),
    (12,'КСЛ'),
    (12,'Ст'),
    (13,'Лам'),
    (13,'Пш'),
    (13,'В'),
    (14,'КСН'),
    (14,'В'),
    (14,'КСлд'),
    (15,'КВ'),
    (15,'КД'),
    (15,'В'),
    (15,'Д'),
    (16,'В'),
    (16,'Ипа'),
    (16,'Лаг'),
    (17,'БС'),
    (18,'БС'),
    (18,'БП'),
    (18,'КС'),
    (19,'БС'),
    (19,'Пш'),
    (19,'Лам'),
    (20,'КС'),
    (21,'БС'),
    (22,'КСН'),
    (22,'КД'),
    (22,'КВ'),
    (22	,'В'),
	(23,'КСЛ'),
    (23,'БС'),
    (23,'КВ'),
    (23,'К'),
    (24,'ПШ'),
    (24,'Лам'),
    (24,'БС'),
	(24,'БП'),
    (25,'КД'),
    (25,'Ипа'),
    (25,'Ш'),
    (25,'БПС'),
    (26,'К'),
    (26,'Лам'),
	(26,'И'),
    (26,'Ш'),
    (27,'Ст'),
--    (27,'БВ'),
    (27,'Ш'),
    (27,'И'),
	(28,'Ст'),
    (28,'Р'),
    (28,'КСН'),
    (28,'КВ'),
    (29,'В'),
    (29,'Пш'),
--	(29,'БВ'),
    (29,'Э'),
    (30,'БПС'),
    (30,'КВ'),
    (30,'Лам'),
    (30,'БД'),
	(31,'Ш'),
    (31,'И'),
--    (31,'БВ'),
    (31,'Э'),
    (32,'Ш'),
    (32,'И'),
	(32,'Лам');
    
    