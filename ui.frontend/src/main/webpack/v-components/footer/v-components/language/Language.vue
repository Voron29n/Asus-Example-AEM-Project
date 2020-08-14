<template>
    <div class="footer-language" id="extra_link">
        <div id="footer_country_link">
            <img :src="languageData.fileReference" alt=""/>
            <a :href="languageData.linkTo" :target="languageData.linkUrlTarget">{{languageData.descriptionLink}}</a>
        </div>
    </div>
</template>

<script>

export default {
    props: {
        languageData: Object,
        default: () => ({})
    },
    
};
</script>

<style lang="scss">
@import "./language_default";
@import "./language_media";
</style>