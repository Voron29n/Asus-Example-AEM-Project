<template>
    <div class="footer-copyrights" id="aai-copyright">
        <ul id="copyright">
            <li 
                 v-for="copyrightsItem in copyrightsData.copyrights"
                 :key="copyrightsItem.descriptionLink"
            >
                <a :href="copyrightsItem.linkTo" :target="copyrightsItem.linkUrlTarget">{{copyrightsItem.descriptionLink}}</a>
            </li>
		</ul>
    </div>
</template>

<script>
export default {
    props: {
        copyrightsData: Object,
    },
    
};
</script>

<style lang="scss">
@import "./copyrights_default";
@import "./copyrights_media";
</style>