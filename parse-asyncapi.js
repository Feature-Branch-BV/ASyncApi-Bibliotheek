const parser = require('@asyncapi/parser');
const {AsyncAPIDocument} = require("@asyncapi/parser");
const avroSchemaParser = require('@asyncapi/avro-schema-parser')
const fs = require('fs');

function read(inputFilePath) {
    parser.registerSchemaParser(avroSchemaParser);
    fs.readFile(inputFilePath, 'utf8', (err, data) => {
        if (err) {
            console.error(err);
            return;
        }
        try {
            parst(data, inputFilePath);
        } catch (e) {
            console.log(e);
        }
    });
}

async function parst(data, inputfile) {
    const doc = await parser.parse(data);
    var stringifiedDocument = AsyncAPIDocument.stringify(doc);
    fs.writeFile((inputfile + 'p'), stringifiedDocument, 'utf8', function (err) {
        if (err) {
            console.log("An error occured while writing JSON Object to File.");
            return console.log(err);
        }

        console.log("JSON file has been saved.") ;
    })
}

const args = process.argv.slice(2);
for (const arg of args) {
    read(arg)
}
