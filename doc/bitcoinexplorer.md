##m.1 获取区块hash详情    
method：GET  
url: /block/getRecentBlocks

```json


response：
 {
        "blockhash": "0000000000000000001ec53a5934fa44779d8ab375605cc80fc1f2eb96c76ce8",
        "height": 580689,
        "time": "2019-06-14T13:16:03.057+0000",
        "txsize": 1818,
        "size": 1115746
    },
    {
        "blockhash": "000000000000000000119eed9e97a87ae33a6b04a504daecab57b5fdf90ab807",
        "height": 580658,
        "time": "2019-06-14T13:16:03.057+0000",
        "txsize": 1314,
        "size": 1235746
    }

```

| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    blockhash|   String  |  区块hash |
|    height   |   Integer |  区块hash |
|    time     |   Data    |  区块时间 |
|    txsize   |   Integer |  交易次数 |
|    size     |   Integer |  区块大小 |



##m.2 根据区块hash获得详情    
method：GET   
url: /block/getBlockhash?blockhash={blockhash}


```json
{
    "blockhash": "0000000000000000001977cc76a51d81f9dbcda92f05c17ae649423c8ae5857f",
    "heigth": 580582,
    "prevBlock": "000000000000000000062da626194c52e82547cb36e0e713efdb9c9214516aad",
    "nextBlock": "00000000000000000011723cc650765b9788f9b193d938f49e200569e9b03941",
    "merkleRoot": "76ccc53957b99aa552a019ce93de939d2f5a6e5ee4f01161aa335f71ae73500e",
    "txSize": 1200,
    "outputTotal": 4411.45080838,
    "fees": 0.49897166,
    "time": 1560519234148,
    "difficulty": 7459680720542.3,
    "sise": 2455
}

```
| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    blockhash      |   String  |  区块hash        |
|    height         |   Integer |  区块高度        |
|    prevBlock      |   String  |  前一个区块          |
|    nextBlock      |   String  |  后一个区块       |
|    merkleRoot     |   String  |  梅尔克数树        |
|    txSize         |   Short   |  交易数量         |
|    fees           |   Double  |  交易费用         |
|    time           |   Long    |  交易时间        |   
|    difficulty     |   Double  |  出块难度        |
|    sise           |   Integer |  区块大小         |
|    outputTotal    |   Double  |  总输出         |



##m.3 根据区块高度获得详情   
method：GET   
url: /block/getByHeight?height={height}
```json

{
    "blockhash": "0000000000000000001977cc76a51d81f9dbcda92f05c17ae649423c8ae5857f",
    "heigth": 580582,
    "prevBlock": "000000000000000000062da626194c52e82547cb36e0e713efdb9c9214516aad",
    "nextBlock": "00000000000000000011723cc650765b9788f9b193d938f49e200569e9b03941",
    "merkleRoot": "76ccc53957b99aa552a019ce93de939d2f5a6e5ee4f01161aa335f71ae73500e",
    "txSize": 1200,
    "outputTotal": 4411.45080838,
    "fees": 0.49897166,
    "time": 1560519375283,
    "difficulty": 7459680720542.3,
    "sise": 2455
}

```
| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    blockhash      |   String  |  区块hash        |
|    height         |   Integer |  区块高度        |
|    prevBlock      |   String  |  前一个区块          |
|    nextBlock      |   String  |  后一个区块       |
|    merkleRoot     |   String  |  梅尔克数树        |
|    txSize         |   Short   |  交易数量         |
|    fees           |   Double  |  交易费用         |
|    time           |   Long    |  交易时间        |   
|    difficulty     |   Double  |  出块难度        |
|    sise           |   Integer |  区块大小         |
|    outputTotal    |   Double  |  总输出         |



##m.4 根据区块大小获得详情 

method：GET   
url: /block/getBySize?size={size}


```json
successResponse：
{
    "blockhash": "0000000000000000002221bb70a15806c342209ce4764ee746d4f27ca786d4b3",
    "heigth": 580582,
    "prevBlock": "0000000000000000001323870563ec1ab6fadd4bf10f00b19d755cd9cb91eb24",
    "nextBlock": "000000000000000000208d25e1f467df2050862658fe0f217d790ad7e735dbff",
    "merkleRoot": "6d53e3757cc9376a973fb0a480879c9b08cc28973904dcfa646f7a7b9dc7f679",
    "txSize": 1388,
    "outputTotal": 17542.41455554,
    "fees": 0.49897166,
    "time": 1560519942086,
    "difficulty": 7459680720542.3,
    "sise": 2405
}
```
| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    blockhash      |   String  |  区块hash        |
|    height         |   Integer |  区块高度        |
|    prevBlock      |   String  |  前一个区块          |
|    nextBlock      |   String  |  后一个区块       |
|    merkleRoot     |   String  |  梅尔克数树        |
|    txSize         |   Short   |  交易数量         |
|    fees           |   Double  |  交易费用         |
|    time           |   Long    |  交易时间        |   
|    difficulty     |   Double  |  出块难度        |
|    sise           |   Integer |  区块大小         |
|    outputTotal    |   Double  |  总输出         |



##m.5 根据区块地址获得详情 

method：GET   
url: /block/getByAddress?address={address}

```json
successResponse：
{
    "address": "1Ckc9bQWux4NhaqDiFspuhzb3zn7D3uqAU",
    "blockhash": "80e89c34ffdd94f03f3af401b99505ad2807b8e5",
    "numberOfTrades": 14,
    "totalNum": 0.09691501,
    "finalBTC": 0
}
```

| ResponseField     |     Type |   Description   | 
| :--------------:  | :--------:| :------: |
|    blockhash      |   String   |  区块hash        |
|    address        |   String   |  区块地址        |
|    numberOfTrades |   Integer  |  交易次数        |
|    totalNum       |   double   |  交易金额        |
|    finalBTC       |   Integer  |  最终交易        |


