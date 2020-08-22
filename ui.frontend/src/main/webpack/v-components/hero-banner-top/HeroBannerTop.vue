<template>
<div>
    <v-images :images-data="imagesData"></v-images>      
</div>
</template>

<script>
import ImagesData from './v-components/images/Images'

export default {
    components: {
        "v-images": ImagesData,
    },
    props: {
        heroItems: {
            type: String,
            required: false,
        },
    },
    computed: {
        imagesData() {
            return {
                heroItems: JSON.parse(this.$props.heroItems),
            };
        },
    },
};

</script>

<style lang="scss">
@import "./v-style/hero_banner_top_default";
@import "./v-style/hero_banner_top_media";
</style>