document.addEventListener(
    "refreshVue",
    function (e) {
        console.log("refresh function");
        //        if (!document.querySelector(`meta[name="customRefreshVueComponent"]`)) {
        //            createMetaTag();
        //        }
        //        let metaTagInfo = document.querySelector(`meta[name="customRefreshVueComponent"]`);
        //        let refreshValue = metaTagInfo.getAttribute("refreshValue");
        //        metaTagInfo.removeAttribute("refreshValue");
        //        refreshValue = Number(refreshValue) + 1 ;
        //        metaTagInfo.setAttribute("refreshValue", refreshValue);
        var event2 = new CustomEvent(`refreshVue`);
        window.frames[0].document.dispatchEvent(event2);
    },
    false
);

function createMetaTag() {
    let metaTag = document.createElement("meta");
    metaTag.setAttribute("name", "customRefreshVueComponent");
    metaTag.setAttribute("refreshValue", 0);
    document.head.appendChild(metaTag);
}
