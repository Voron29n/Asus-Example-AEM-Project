<template>
    <div id="proart__images-carousel" class="row">
        <VueTitle :title-data="title"></VueTitle>
        <VueImages :images-data="imagesList"></VueImages>
    </div>
</template>

<script>
export default {
    components: {
        VueTitle: () =>
            import(
                /* webpackChunkName: "ProArtImagesCarousel" */ "./v-components/title/Title"
            ),
        VueImages: () =>
            import(
                /* webpackChunkName: "ProArtImagesCarousel" */ "./v-components/images/Images"
            ),
    },
    data() {
        return {
            title: null,
            imagesList: null,
        };
    },
    props: {
        resourcePath: {
            type: String,
            required: false,
        },
    },
    created() {
        this.getFetchData();
    },
    methods: {
        async getFetchData() {
            let response = await this.$_GET_MODEL(this.resourcePath);
            if (response.status >= 200 && response.status < 300) {
                var responseJson = await response.json();
                this.fillData(responseJson);
            }
        },
        fillData(responseJson) {
            this.title = responseJson.title;
            this.imagesList = responseJson.imagesList;
        },
    },
};

import (/* webpackChunkName: "ProArtImagesCarousel" */ './v-style/_images_carousel_default.scss');
import (/* webpackChunkName: "ProArtImagesCarousel" */ './v-style/_images_carousel_media.scss');
</script>
