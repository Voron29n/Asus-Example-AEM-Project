function getJSON(url, callback) {
    let xhr = new XMLHttpRequest();
    console.log("11111");
    xhr.onload = function() {
        callback(this.responseText)
    };
    xhr.open('GET', url, true);
    xhr.send();
};

export function getUsefulContents(url, callback) {
    console.log("22222");
    require('b');
    getJSON(url, data => callback(JSON.parse(data)));
}




// module.exports.fn = require('./qwe.js');

// let exports = {};
// const module = {};
// module.exports = exports;

// exports.a = require('./qwe.js');
// // module.exports = {
// //   hello: () => console.log('hello')
// // }
// console.log(module.exports)


function require(value) {
    module.exports = {};
    var exports = module.exports;

    var aa = {
            a: () => { return 'a' },
            b: () => { return require('./qwe.js') }
        }
        // module.exports = aa.sad;

    // aa.array.forEach((element) => {
    //     if(element.id === value) {
    //         module.exports = element.val
    //     } 
    // });

    aa.array.forEach((item, index) => {
        if (index === value) {
            module.exports = item
        }
    });

    return module.exports;
}