<template>
<div id="article_text-component-vue">
    <v-title :title-data="titleData"></v-title>
    <v-description :description-data="descriptionData"></v-description> 
</div>
</template>

<script>
import TitleData from './v-components/title/Title'
import DescriptionData from './v-components/description/Description'

export default {
    components: {
        "v-title": TitleData,
        "v-description": DescriptionData,
    },
    props: {
        textTitle: {
            type: String,
            required: false,
        },
        textDescription: {
            type: String,
            required: false,
        },
    },
    computed: {
        titleData() {
            return {
                textTitle: this.$props.textTitle,
            };
        },
        descriptionData() {
            return {
                textDescription: this.$props.textDescription,
            };
        },
    },
};

</script>

<style lang="scss" scoped>
@import "./v-style/article_text_default";
@import "./v-style/article_text_media";
</style>